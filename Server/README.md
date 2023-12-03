## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

```
Server
├─ .vscode
│  └─ settings.json
├─ bin
│  └─ main
│     └─ java
│        └─ com
│           └─ bigcousin
│              └─ chatroom
│                 └─ sever
│                    ├─ APP.class
│                    ├─ authentication
│                    │  ├─ User.class
│                    │  ├─ UserHandler.class
│                    │  └─ UserManager.class
│                    ├─ ChatServer.class
│                    ├─ entrance
│                    │  └─ ServerEntrance.class
│                    ├─ message
│                    │  ├─ Message.class
│                    │  ├─ MessageSource.class
│                    │  ├─ MessageType.class
│                    │  └─ SystemMessage.class
│                    ├─ room
│                    │  ├─ Room.class
│                    │  └─ RoomManager.class
│                    └─ ui
│                       ├─ LogOutputWindow$1.class
│                       └─ LogOutputWindow.class
├─ lib
│  ├─ commons-codec-1.11.jar
│  ├─ commons-logging-1.2.jar
│  ├─ fluent-hc-4.5.10.jar
│  ├─ httpclient-4.5.10.jar
│  ├─ httpclient-cache-4.5.10.jar
│  ├─ httpclient-osgi-4.5.10.jar
│  ├─ httpclient-win-4.5.10.jar
│  ├─ httpcore-4.4.12.jar
│  ├─ httpmime-4.5.10.jar
│  ├─ jna-4.5.2.jar
│  └─ jna-platform-4.5.2.jar
├─ README.md
└─ src
   └─ main
      └─ java
         └─ com
            └─ bigcousin
               └─ chatroom
                  └─ sever
                     ├─ APP.java
                     ├─ authentication
                     │  ├─ User.java
                     │  ├─ UserHandler.java
                     │  └─ UserManager.java
                     ├─ ChatServer.java
                     ├─ entrance
                     │  └─ ServerEntrance.java
                     ├─ message
                     │  ├─ Message.java
                     │  ├─ MessageSource.java
                     │  ├─ MessageType.java
                     │  └─ SystemMessage.java
                     ├─ room
                     │  ├─ Room.java
                     │  └─ RoomManager.java
                     └─ ui
                        └─ LogOutputWindow.java

```