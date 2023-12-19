# BC-chat_beta

在这个项目中，我们将设计并实现一个简单的Java聊天室系统。该系统包括服务端和客户端，允许用户创建账号、登录、发送文本消息，并在创建的房间中进行实时聊天。 

## 参与人员

### BigCousin

- **姓名：** BigCousin
- **角色：** 项目创始人
- **GitHub：** [BigCousin的GitHub](https://github.com/van-darkness)

- **姓名：** QianyiZSX
- **角色：** 参与者
- **GitHub：** [QianyiZSX的GitHub](https://github.com/QianyiZSX)

### 辅助
- chatGPT
- New Bing 

## 如何开始

# 示例命令
git clone https://github.com/van-darkness/BC-chat_beta.git
cd BC-chat_beta
npm install
npm start


## 开发日志
详见 开发日志.md
## 项目结构

```
BC-chat_beta
├─ .idea
│  ├─ artifacts
│  │  ├─ Client_jar.xml
│  │  └─ Server_jar.xml
│  ├─ misc.xml
│  ├─ modules.xml
│  ├─ uiDesigner.xml
│  ├─ vcs.xml
│  └─ workspace.xml
├─ .vscode
│  └─ settings.json
├─ BC-chat_beta.iml
├─ bin
│  ├─ main
│  │  ├─ java
│  │  │  └─ com
│  │  │     └─ bigcousin
│  │  │        └─ chatroom
│  │  │           ├─ client
│  │  │           │  ├─ app
│  │  │           │  │  ├─ ClientAPP.class
│  │  │           │  │  └─ Test.class
│  │  │           │  ├─ controller
│  │  │           │  │  └─ MainController.class
│  │  │           │  ├─ core
│  │  │           │  │  ├─ ChatClient$ObjectReceiver.class
│  │  │           │  │  └─ ChatClient.class
│  │  │           │  ├─ exception
│  │  │           │  │  └─ ChatRoomWindowNotInitializedException.class
│  │  │           │  └─ ui
│  │  │           │     ├─ BubblePanel.class
│  │  │           │     ├─ ChatRoomWindow$1.class
│  │  │           │     ├─ ChatRoomWindow$2.class
│  │  │           │     ├─ ChatRoomWindow.class
│  │  │           │     ├─ LoginWindow$1.class
│  │  │           │     ├─ LoginWindow$2.class
│  │  │           │     ├─ LoginWindow.class
│  │  │           │     ├─ RoomSelectionWindow$1.class
│  │  │           │     ├─ RoomSelectionWindow$2.class
│  │  │           │     ├─ RoomSelectionWindow.class
│  │  │           │     ├─ RoomSelectWindow.class
│  │  │           │     └─ RoomSelectWindow.form
│  │  │           ├─ common
│  │  │           │  ├─ info
│  │  │           │  │  ├─ room
│  │  │           │  │  │  └─ RoomInfo.class
│  │  │           │  │  └─ user
│  │  │           │  │     ├─ UserInfo.class
│  │  │           │  │     └─ UserInfoList.class
│  │  │           │  ├─ message
│  │  │           │  │  ├─ ChatMessage.class
│  │  │           │  │  ├─ LoginMessage.class
│  │  │           │  │  ├─ LogoutMessage.class
│  │  │           │  │  ├─ Message.class
│  │  │           │  │  ├─ MessageType.class
│  │  │           │  │  ├─ RoomSelectionMessage.class
│  │  │           │  │  └─ SystemMessage.class
│  │  │           │  └─ request
│  │  │           │     ├─ ClientRequest.class
│  │  │           │     ├─ ClientRequestType.class
│  │  │           │     └─ ServerRequest.class
│  │  │           └─ server
│  │  │              ├─ app
│  │  │              │  └─ ServerAPP.class
│  │  │              ├─ exception
│  │  │              │  ├─ NullMessageException.class
│  │  │              │  └─ RoomCreatException.class
│  │  │              ├─ service
│  │  │              │  ├─ ChatServer$ClientHandler.class
│  │  │              │  ├─ ChatServer$ServerEntrance.class
│  │  │              │  ├─ ChatServer.class
│  │  │              │  └─ Room.class
│  │  │              └─ util
│  │  │                 ├─ InfoProcessor.class
│  │  │                 └─ TestOpre.class
│  │  └─ resources
│  │     └─ images
│  │        └─ image.jpg
│  └─ META-INF
│     └─ MANIFEST.MF
├─ docs
│  ├─ client端开发注意事项.md
│  ├─ DemandAnalysis.md
│  ├─ image-1.png
│  ├─ image-2.png
│  ├─ image-3.png
│  ├─ image-4.png
│  ├─ image-5.png
│  ├─ image-6.png
│  ├─ image.png
│  ├─ img.png
│  ├─ img_1.png
│  ├─ img_10.png
│  ├─ img_2.png
│  ├─ img_3.png
│  ├─ img_4.png
│  ├─ img_5.png
│  ├─ img_6.png
│  ├─ img_7.png
│  ├─ img_8.png
│  ├─ img_9.png
│  ├─ server端开发事项.md
│  └─ 开发日志.md
├─ lib
│  ├─ Clock3.0.jar
│  ├─ Clock5.6.jar
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
├─ out
│  ├─ artifacts
│  │  ├─ BC_chat_beta_jar
│  │  ├─ BC_chat_Test
│  │  │  └─ BC chat_Test.jar
│  │  ├─ Clent
│  │  ├─ Clent_jar
│  │  │  └─ BC-chat_beta.jar
│  │  └─ ClientTest
│  └─ production
│     ├─ BC-chat_beta
│     │  ├─ com
│     │  │  └─ intellij
│     │  │     └─ uiDesigner
│     │  │        └─ core
│     │  │           ├─ AbstractLayout.class
│     │  │           ├─ DimensionInfo.class
│     │  │           ├─ GridConstraints.class
│     │  │           ├─ GridLayoutManager.class
│     │  │           ├─ HorizontalInfo.class
│     │  │           ├─ LayoutState.class
│     │  │           ├─ Spacer.class
│     │  │           ├─ SupportCode$TextWithMnemonic.class
│     │  │           ├─ SupportCode.class
│     │  │           ├─ Util.class
│     │  │           └─ VerticalInfo.class
│     │  ├─ main
│     │  │  ├─ java
│     │  │  │  └─ com
│     │  │  │     └─ bigcousin
│     │  │  │        └─ chatroom
│     │  │  │           ├─ client
│     │  │  │           │  ├─ app
│     │  │  │           │  │  ├─ ClientAPP.class
│     │  │  │           │  │  └─ Test.class
│     │  │  │           │  ├─ controller
│     │  │  │           │  │  └─ MainController.class
│     │  │  │           │  ├─ core
│     │  │  │           │  │  ├─ ChatClient$ObjectReceiver.class
│     │  │  │           │  │  └─ ChatClient.class
│     │  │  │           │  ├─ exception
│     │  │  │           │  │  └─ ChatRoomWindowNotInitializedException.class
│     │  │  │           │  └─ ui
│     │  │  │           │     ├─ BubblePanel.class
│     │  │  │           │     ├─ ChatRoomWindow$1.class
│     │  │  │           │     ├─ ChatRoomWindow$2.class
│     │  │  │           │     ├─ ChatRoomWindow.class
│     │  │  │           │     ├─ LoginWindow$1.class
│     │  │  │           │     ├─ LoginWindow$2.class
│     │  │  │           │     ├─ LoginWindow.class
│     │  │  │           │     ├─ RoomSelectionWindow$1.class
│     │  │  │           │     ├─ RoomSelectionWindow$2.class
│     │  │  │           │     ├─ RoomSelectionWindow.class
│     │  │  │           │     └─ RoomSelectWindow.class
│     │  │  │           ├─ common
│     │  │  │           │  ├─ info
│     │  │  │           │  │  ├─ room
│     │  │  │           │  │  │  └─ RoomInfo.class
│     │  │  │           │  │  └─ user
│     │  │  │           │  │     ├─ UserInfo.class
│     │  │  │           │  │     └─ UserInfoList.class
│     │  │  │           │  ├─ message
│     │  │  │           │  │  ├─ ChatMessage.class
│     │  │  │           │  │  ├─ LoginMessage.class
│     │  │  │           │  │  ├─ LogoutMessage.class
│     │  │  │           │  │  ├─ Message.class
│     │  │  │           │  │  ├─ MessageType.class
│     │  │  │           │  │  ├─ RoomSelectionMessage.class
│     │  │  │           │  │  └─ SystemMessage.class
│     │  │  │           │  └─ request
│     │  │  │           │     ├─ ClientRequest.class
│     │  │  │           │     ├─ ClientRequestType.class
│     │  │  │           │     └─ ServerRequest.class
│     │  │  │           └─ server
│     │  │  │              ├─ app
│     │  │  │              │  └─ ServerAPP.class
│     │  │  │              ├─ exception
│     │  │  │              │  ├─ NullMessageException.class
│     │  │  │              │  └─ RoomCreatException.class
│     │  │  │              ├─ service
│     │  │  │              │  ├─ ChatServer$1.class
│     │  │  │              │  ├─ ChatServer$ClientHandler.class
│     │  │  │              │  ├─ ChatServer$ServerEntrance.class
│     │  │  │              │  ├─ ChatServer.class
│     │  │  │              │  └─ Room.class
│     │  │  │              └─ util
│     │  │  │                 ├─ InfoProcessor.class
│     │  │  │                 └─ TestOpre.class
│     │  │  └─ resources
│     │  │     └─ images
│     │  │        └─ image.jpg
│     │  └─ META-INF
│     │     └─ MANIFEST.MF
│     └─ Client
│        └─ main
│           └─ java
│              └─ com
│                 └─ bigcousin
│                    └─ chatroom
│                       └─ client
│                          ├─ ClientAPP.class
│                          ├─ messages
│                          │  ├─ LogInMessage.class
│                          │  └─ Message.class
│                          ├─ ui
│                          │  ├─ LoginWindow$1.class
│                          │  └─ LoginWindow.class
│                          └─ user
│                             ├─ InRoomStatus.class
│                             ├─ NotInRoomStatus.class
│                             ├─ NotLoggedInStatus.class
│                             ├─ ServerConnection.class
│                             ├─ User.class
│                             ├─ UserCore.class
│                             └─ UserStatus.class
├─ README.md
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com
│  │  │     └─ bigcousin
│  │  │        └─ chatroom
│  │  │           ├─ client
│  │  │           │  ├─ app
│  │  │           │  │  ├─ ClientAPP.java
│  │  │           │  │  └─ Test.java
│  │  │           │  ├─ controller
│  │  │           │  │  └─ MainController.java
│  │  │           │  ├─ core
│  │  │           │  │  └─ ChatClient.java
│  │  │           │  ├─ exception
│  │  │           │  │  └─ ChatRoomWindowNotInitializedException.java
│  │  │           │  └─ ui
│  │  │           │     ├─ BubblePanel.java
│  │  │           │     ├─ ChatRoomWindow.java
│  │  │           │     ├─ LoginWindow.java
│  │  │           │     ├─ RoomSelectionWindow.java
│  │  │           │     ├─ RoomSelectWindow.form
│  │  │           │     └─ RoomSelectWindow.java
│  │  │           ├─ common
│  │  │           │  ├─ info
│  │  │           │  │  ├─ room
│  │  │           │  │  │  └─ RoomInfo.java
│  │  │           │  │  └─ user
│  │  │           │  │     ├─ UserInfo.java
│  │  │           │  │     └─ UserInfoList.java
│  │  │           │  ├─ message
│  │  │           │  │  ├─ ChatMessage.java
│  │  │           │  │  ├─ LoginMessage.java
│  │  │           │  │  ├─ LogoutMessage.java
│  │  │           │  │  ├─ Message.java
│  │  │           │  │  ├─ MessageType.java
│  │  │           │  │  ├─ RoomSelectionMessage.java
│  │  │           │  │  └─ SystemMessage.java
│  │  │           │  └─ request
│  │  │           │     ├─ ClientRequest.java
│  │  │           │     ├─ ClientRequestType.java
│  │  │           │     └─ ServerRequest.java
│  │  │           └─ server
│  │  │              ├─ app
│  │  │              │  └─ ServerAPP.java
│  │  │              ├─ exception
│  │  │              │  ├─ NullMessageException.java
│  │  │              │  └─ RoomCreatException.java
│  │  │              ├─ service
│  │  │              │  ├─ ChatServer.java
│  │  │              │  └─ Room.java
│  │  │              └─ util
│  │  │                 ├─ InfoProcessor.java
│  │  │                 └─ TestOpre.java
│  │  └─ resources
│  │     └─ images
│  │        └─ image.jpg
│  └─ META-INF
│     └─ MANIFEST.MF
└─ structure101-settings.java.hsw

```
