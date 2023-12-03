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
## 项目结构
```

```

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
### 客户端

```
Client
├─ .vscode
│  └─ settings.json
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
├─ image.jpg
├─ lib
├─ REDEME.md
└─ src
   └─ main
      └─ java
         └─ com
            └─ bigcousin
               └─ chatroom
                  └─ client
                     ├─ ClientAPP.java
                     ├─ messages
                     │  ├─ LogInMessage.java
                     │  └─ Message.java
                     ├─ ui
                     │  └─ LoginWindow.java
                     └─ user
                        ├─ InRoomStatus.java
                        ├─ NotInRoomStatus.java
                        ├─ NotLoggedInStatus.java
                        ├─ ServerConnection.java
                        ├─ User.java
                        ├─ UserCore.java
                        └─ UserStatus.java

```
### 服务端
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