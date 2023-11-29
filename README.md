# BC-chat_beta

在这个项目中，我们将设计并实现一个简单的Java聊天室系统。该系统包括服务端和客户端，允许用户创建账号、登录、发送文本消息，并在创建的房间中进行实时聊天。 

## 参与人员

### BigCousin

- **姓名：** BigCousin
- **角色：** 项目创始人
- **联系方式：** 18855794326
- **GitHub：** [BigCousin的GitHub](https://github.com/van-drakness)
### 
### 辅助—
- chatGPT
- New Bing 
## 项目结构
```
BC-chat_beta
├─ docs
│  ├─ client端开发注意事项.md
│  ├─ data库开发注意事项.md
│  ├─ DemandAnalysis.md
│  ├─ image-1.png
│  ├─ image-2.png
│  ├─ image-3.png
│  ├─ image-4.png
│  ├─ image-5.png
│  ├─ image.png
│  ├─ server端开发事项.md
│  └─ 开发日志.md
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
├─ src
│  ├─ client
│  │  ├─ Client.java
│  │  ├─ core
│  │  │  ├─ Core.java
│  │  │  └─ ServerConnection.java
│  │  ├─ data
│  │  └─ gui
│  ├─ data
│  │  ├─ parameter
│  │  ├─ room
│  │  │  └─ RoomData.txt
│  │  ├─ server
│  │  │  └─ ServerData.txt
│  │  └─ user
│  │     ├─ User.java
│  │     └─ UserData.txt
│  └─ server
│     ├─ entrance
│     │  └─ ServerEntrance.java
│     ├─ handlers
│     │  └─ ClientHandler.java
│     ├─ Server.java
│     └─ space
│        ├─ Lobby.java
│        └─ Room.java
└─ test
   └─ Test.java
```

## 如何开始



```bash
# 示例命令
git clone https://github.com/van-darkness/BC-chat_beta.git
cd BC-chat_beta
npm install
npm start

```

