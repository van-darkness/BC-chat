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
├─ BC-chat_beta.iml
├─ bin
│  └─ main
│     └─ java
│        └─ com
│           └─ bigcousin
│              └─ chatroom
│                 └─ client
│                    ├─ ClientAPP.class
│                    ├─ messages
│                    │  ├─ LogInMessage.class
│                    │  └─ Message.class
│                    ├─ ui
│                    │  ├─ LoginWindow$1.class
│                    │  └─ LoginWindow.class
│                    └─ user
│                       ├─ InRoomStatus.class
│                       ├─ NotInRoomStatus.class
│                       ├─ NotLoggedInStatus.class
│                       ├─ ServerConnection.class
│                       ├─ User.class
│                       ├─ UserCore.class
│                       └─ UserStatus.class
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
│  ├─ server端开发事项.md
│  └─ 开发日志.md
├─ image.jpg
├─ out
│  └─ production
│     ├─ BC-chat_beta
│     │  └─ main
│     │     └─ java
│     │        └─ com
│     │           └─ bigcousin
│     │              └─ chatroom
│     │                 ├─ client
│     │                 │  ├─ ClientAPP.class
│     │                 │  ├─ messages
│     │                 │  │  ├─ LogInMessage.class
│     │                 │  │  └─ Message.class
│     │                 │  ├─ ui
│     │                 │  │  ├─ LoginWindow$1.class
│     │                 │  │  └─ LoginWindow.class
│     │                 │  └─ user
│     │                 │     ├─ InRoomStatus.class
│     │                 │     ├─ NotInRoomStatus.class
│     │                 │     ├─ NotLoggedInStatus.class
│     │                 │     ├─ ServerConnection.class
│     │                 │     ├─ User.class
│     │                 │     ├─ UserCore.class
│     │                 │     └─ UserStatus.class
│     │                 └─ server
│     │                    ├─ APP.class
│     │                    ├─ authentication
│     │                    │  ├─ User.class
│     │                    │  ├─ UserHandler.class
│     │                    │  └─ UserManager.class
│     │                    ├─ ChatServer.class
│     │                    ├─ entrance
│     │                    │  ├─ EndOfTransmission.class
│     │                    │  └─ ServerEntrance.class
│     │                    ├─ message
│     │                    │  ├─ LogInMessage.class
│     │                    │  ├─ Message.class
│     │                    │  ├─ MessageSource.class
│     │                    │  ├─ MessageType.class
│     │                    │  ├─ SystemMessage$1.class
│     │                    │  └─ SystemMessage.class
│     │                    ├─ room
│     │                    │  ├─ Room.class
│     │                    │  └─ RoomManager.class
│     │                    └─ ui
│     │                       ├─ LogOutputWindow$1.class
│     │                       └─ LogOutputWindow.class
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
├─ Server
│  └─ .idea
│     └─ workspace.xml
└─ src
   └─ main
      └─ java
         └─ com
            └─ bigcousin
               └─ chatroom
                  ├─ client
                  │  ├─ ClientAPP.java
                  │  └─ ui
                  │     └─ LoginWindow.java
                  ├─ data
                  │  ├─ messages
                  │  ├─ rooms
                  │  └─ user
                  │     ├─ InRoomStatus.java
                  │     ├─ NotInRoomStatus.java
                  │     ├─ NotLoggedInStatus.java
                  │     ├─ User.java
                  │     ├─ UserCore.java
                  │     └─ UserStatus.java
                  └─ server
                     ├─ APP.java
                     ├─ authentication
                     │  ├─ UserHandler.java
                     │  └─ UserManager.java
                     ├─ ChatServer.java
                     ├─ entrance
                     │  ├─ EndOfTransmission.java
                     │  └─ ServerEntrance.java
                     ├─ message
                     │  ├─ LogInMessage.java
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