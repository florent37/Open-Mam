# Open-Mam

Open-Mam is an open-source mobile application management, 
With this project, you will have your own mobile store, linked with your own server.

The main goal is to distribute your applications to your employers, your beta-testers or your clients, 
but without sending your application binaries on the cloud, you will handle their storage.

# API

The api has been thinked to be used on any server, even in :
- a hosted server (PHP)
- a mutualised server (PHP)
- a server that does not allow url-rewriting
- a server without database (use file mode or sqllite)
- a server that deny file storage (allow to store apk's outside, eg: in a git or a ftp)

# Android

The Android application is like the Play Store, but contains only your own applications, 
it's built with open-source libraries, and has a material look & feel.

To have an Android store, you can :
- use the given application binary (link in this README), and link it to you own server
or 
- fork it, then modify the `configuration.gradle` file to change his name, his colors and directly couple with your server

# Roadmap

There's a lot of work to publish this project, I'm currently working on :

- Implementing the API (PHP / Mysql)
- Developping the Android Client
- Developping the front website
- Versioning the API
- Versioning the Android Client
- Adding notifications on Android Client

# Contribution

Feel free to contribute to this project by sending me pull requests or issues
Contact me on my email champigny.florent@gmail.com if you have any question about Open-Mam
