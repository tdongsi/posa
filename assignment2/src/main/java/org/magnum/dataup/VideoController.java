/*
 * 
 * Copyright 2014 Jules White
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.magnum.dataup;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.magnum.dataup.model.Video;
import org.magnum.dataup.model.VideoStatus;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VideoController {

	private static final AtomicLong currentId = new AtomicLong(0L);
	private static VideoFileManager videoDataMgr;

	private Map<Long, Video> videos = new HashMap<Long, Video>();

	private void checkAndSetId(Video entity) {
		if (entity.getId() == 0) {
			entity.setId(currentId.incrementAndGet());
		}
	}

	private String getDataUrl(long videoId) {
		String url = getUrlBaseForLocalServer() + "/video/" + videoId + "/data";
		return url;
	}

	private String getUrlBaseForLocalServer() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String base = "http://"
				+ request.getServerName()
				+ ((request.getServerPort() != 80) ? ":"
						+ request.getServerPort() : "");
		return base;
	}

	@RequestMapping(value = { VideoSvcApi.VIDEO_SVC_PATH }, method = { RequestMethod.POST })
	public @ResponseBody Video addVideo(@RequestBody Video entity) {

		checkAndSetId(entity);
		long id = entity.getId();
		entity.setDataUrl(getDataUrl(id));
		videos.put(id, entity);
		
		return entity;

	}
	
	@RequestMapping(value = { VideoSvcApi.VIDEO_SVC_PATH }, method = { RequestMethod.GET } )
	public @ResponseBody Collection<Video> getVideoList() {
		return videos.values();
	}
	
	@ExceptionHandler(IOException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public void handleResourceNotFoundException(IOException ex)
	{
		// A logger is better, but too much work
		System.err.println("Error initializing VideoFileManager or others: " + ex.getMessage());
	}
	
	@RequestMapping(value=VideoSvcApi.VIDEO_DATA_PATH, method=RequestMethod.POST)
	public @ResponseBody VideoStatus addVideoData(
			@PathVariable long id,
			@RequestParam("data") MultipartFile videoData
			) throws IOException {
		
		if ( videoDataMgr == null ) {
			videoDataMgr = VideoFileManager.get();
		}
		
		if (!videos.containsKey(id)) {
			throw new IOException("Cannot find video id: " + Long.toString(id));
		}
		
		if ( !videoData.isEmpty() ) {
			videoDataMgr.saveVideoData(videos.get(id), videoData.getInputStream());
		}
		
		return new VideoStatus(VideoStatus.VideoState.READY);
	}
	
	@RequestMapping(value=VideoSvcApi.VIDEO_DATA_PATH, method=RequestMethod.GET)
	public void getVideoData(
			@PathVariable long id,
			HttpServletResponse response
			) throws IOException {
		if ( videoDataMgr == null ) {
			videoDataMgr = VideoFileManager.get();
		}
		
		if (!videos.containsKey(id)) {
			throw new IOException("Cannot find video id: " + Long.toString(id));
		} else {
			videoDataMgr.copyVideoData(videos.get(id), response.getOutputStream());
		}
	}

}
