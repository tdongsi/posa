Since I did not have time to fill in the code with comments I leave here a short explanation of the application.


The application has 3 screens: Authentication, Home and Video Details.

The Authentication screen, as the name sugests, allows the user to authenticate against the server.
After a success login, the credentials will saved to be used in all future requests to the server.

The Home screen, lists the videos and its rating that were already downloaded or updload by the application.
The user can refresh the screen at any time and pick new videos from the "Gallery" to upload to the server.

The video details allows the user the see the video information and rate it.
If the video was not downloaded before, the user can download it at any time.
Once downloaded the video, the user can play it. The video player is external to the application.


Regarding Architecture

- The AthenticationActivity holds the AuthenticationFragment that retains its instance to handle runtime changes.
- The HomeActivity holds the HomeFragment that retains its instance to handle runtime changes.
- The VideoActivity holds the VideoFragment that retains its instance to handle runtime changes.
- The AthenticationActivity/Fragment will open the HomeActivity/Fragment automatically after logged in.
- The HomeActivity/Fragment will open the VideoActivity/Fragment when one of the listed videos is clicked.
- Every fragment can run one "internal" AsyncTak.


- All HTTP commands are placed inside the VideosController class.
- The HTTP usage is done inside AsynTasks or with an IntentService on the backgroudn thread.
- The previous choice allows the application to never block the UI thread.
- The content providers operations are all executed in a background thread as well.


- The custom application provider was named VideosProvider.
- This provider interacts with 2 tables, the video metadata table and trace of uploaded/downloads videos table.
- The check if a video file already exists or was downloaded is simple and it could be improved if I had more time.
- Basically, if a video URI exists on the trace table, we confirm if the related Video URI file exists on disk.


- The download and upload services show what is happening on the system notification bar.
- Each one of these services will notiy as well the respective screen via LocalBroadcastManager when is done.


- The server video API has one method called validate() to confirm the user credentials.
- Each requested video is automatically enriched with the average rating and the total number os votes.


Last Notes:
Be careful with the mp4 videos that are used to test since some of them simple have unsupported encoding and might not play.
The sample video from the coursea is a video that works well in emulator and my devices. I hope that in yours too.
Available users are: user0, user1, user2, user3, user4 and admin. The password is always pass.
More details in OAuth2SecurityConfiguration.java file.


Regarding the server URL confirguration please have a look here:
https://github.com/juleswhite/mobilecloud-15/blob/master/ex/VideoUploadClient(Secured)/README.md
The Android application requires that you place the server IP in the Constants.java file.


Compilation:
The Android application must have the compiler in compliance level: 1.7
For more details please check this link:
https://github.com/juleswhite/mobilecloud-15/wiki/MobileCloud-15-FAQ#23


Here are some usefull links:
http://sample-videos.com/download-mp4-demo-videos
http://download.wavetlan.com/SVV/Media/HTTP/http-mp4.htm