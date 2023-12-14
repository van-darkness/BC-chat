# BC-chat_beta

在这个项目中，我们将设计并实现一个简单的Java聊天室系统。该系统包括服务端和客户端，允许用户创建账号、登录、发送文本消息，并在创建的房间中进行实时聊天。 

## 参与人员

### BigCousin

- **姓名：** BigCousin
- **角色：** 项目创始人
- **联系方式：** 18855794326
- **GitHub：** [BigCousin的GitHub](https://github.com/van-drakness)
### 
### 辅助
- chatGPT
- New Bing 

## 如何开始



```bash
# 示例命令
git clone https://github.com/van-darkness/BC-chat_beta.git
cd BC-chat_beta
npm install
npm start

```
## 开发注意事项
### Client端
详见 client端开发注意事项.md

### 数据库
详见 数据库开发注意事项.md

### Server端
详见 server端开发事项.md

## 开发日志
详见 开发日志.md
## 项目结构


```
BC-chat_beta
├─ .idea
│  ├─ misc.xml
│  ├─ modules.xml
│  ├─ uiDesigner.xml
│  ├─ vcs.xml
│  └─ workspace.xml
├─ .vscode
│  └─ settings.json
├─ asset
│  └─ icon
│     └─ image.jpg
├─ BC-chat_beta.iml
├─ bin
│  └─ main
│     └─ java
│        └─ com
│           └─ bigcousin
│              └─ chatroom
│                 └─ server
│                    └─ ui
│                       └─ UserListWindows.form
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
│  ├─ img_2.png
│  ├─ img_3.png
│  ├─ img_4.png
│  ├─ img_5.png
│  ├─ server端开发事项.md
│  └─ 开发日志.md
├─ image.jpg
├─ lib
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
│  └─ production
│     ├─ BC-chat_beta
│     │  └─ main
│     │     └─ java
│     │        └─ com
│     │           └─ bigcousin
│     │              └─ chatroom
│     │                 ├─ client
│     │                 │  ├─ app
│     │                 │  │  └─ ChatApp.class
│     │                 │  ├─ core
│     │                 │  │  └─ ChatClient.class
│     │                 │  └─ ui
│     │                 │     ├─ ChatClientUI$1.class
│     │                 │     ├─ ChatClientUI$2.class
│     │                 │     ├─ ChatClientUI.class
│     │                 │     ├─ ChatUI.class
│     │                 │     ├─ LoginUI.class
│     │                 │     ├─ RoomSelectionUI$1.class
│     │                 │     └─ RoomSelectionUI.class
│     │                 ├─ common
│     │                 │  ├─ info
│     │                 │  │  ├─ room
│     │                 │  │  │  ├─ RoomInfo.class
│     │                 │  │  │  └─ RoomInfoList.class
│     │                 │  │  └─ user
│     │                 │  │     ├─ UserInfo.class
│     │                 │  │     └─ UserInfoList.class
│     │                 │  └─ message
│     │                 │     ├─ ChatMessage.class
│     │                 │     ├─ LoginMessage.class
│     │                 │     ├─ Message.class
│     │                 │     ├─ MessageType.class
│     │                 │     └─ RoomSelectionMessage.class
│     │                 └─ server
│     │                    ├─ app
│     │                    │  └─ ServerAPP.class
│     │                    └─ service
│     │                       ├─ ChatServer$ServerEntrance.class
│     │                       ├─ ChatServer.class
│     │                       ├─ room
│     │                       │  └─ Room.class
│     │                       └─ user
│     │                          └─ ClientHandler.class
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
└─ src
   └─ main
      └─ java
         └─ com
            └─ bigcousin
               └─ chatroom
                  ├─ client
                  │  ├─ app
                  │  │  └─ ChatApp.java
                  │  ├─ core
                  │  │  └─ ChatClient.java
                  │  └─ ui
                  │     ├─ ChatClientUI.java
                  │     ├─ ChatUI.java
                  │     ├─ LoginUI.java
                  │     └─ RoomSelectionUI.java
                  ├─ common
                  │  ├─ info
                  │  │  ├─ room
                  │  │  │  ├─ RoomInfo.java
                  │  │  │  └─ RoomInfoList.java
                  │  │  └─ user
                  │  │     ├─ UserInfo.java
                  │  │     └─ UserInfoList.java
                  │  └─ message
                  │     ├─ ChatMessage.java
                  │     ├─ LoginMessage.java
                  │     ├─ Message.java
                  │     ├─ MessageType.java
                  │     └─ RoomSelectionMessage.java
                  └─ server
                     ├─ app
                     │  └─ ServerAPP.java
                     └─ service
                        ├─ ChatServer.java
                        ├─ room
                        │  └─ Room.java
                        └─ user
                           └─ ClientHandler.java

```