<img src="https://github.com/DipLeChip/protocol3/blob/main/p3long.png" width=""></img>
<p align="center">
  <img alt="Latest release" src="https://img.shields.io/github/v/release/gcurtiss/protocol3?color=dodgerblue&include_prereleases&label=Latest%20release&style=flat-square"></img>
<h2 align="center">The Plugin That Runs Avas</h2>
protocol3 is the plugin that runs avas.cc. It manages things like the speed limit, anti-illegals, and commands like vote mute. It also provides quality of life commands and debug information for server administrators.

### Download
You can download the latest version [here](https://github.com/gcurtiss/protocol3/releases/latest)

### Dependencies
At this time, only [ProtocolLib](https://www.spigotmc.org/resources/protocollib.1997/) and [ArmorEquipEvent](https://www.spigotmc.org/resources/lib-armorequipevent.5478/) is required for the plugin to run correctly. Use [Paper 1.16.5 Build #446](https://papermc.io/api/v2/projects/paper/versions/1.16.5/builds/446/downloads/paper-1.16.5-446.jar) or newer.

### Setup
1. Download ProtocolLib and the latest build of Paper for the latest version of Minecraft.
2. Compile protocol3 as shown in the Testing section.
3. Place the protocol3, ProtocolLib, and ArmorEquipEvent jars into your plugins directory.
4. Launch the server.
Note: For testing illegals and speed limit, you cannot be opped. For testing admin commands, you must be opped.

### Testing (Eclipse)
1. Clone this repo.
2. Use Eclipse to import the repo in a workspace. 
3. Right click pom.xml, and use "Run as -> Maven build.."
4. Type "package" in the Goals box. This will save the package configuration. You can later run it with "Run as -> Maven build" and select the configuration.
5. A .jar file will be produced in /target called `p3 or p3-3-shaded.jar` 
6. Place this .jar in your plugins directory on your server.

### Testing (IntelliJ)
1. Clone the repo
2. Open the project. Select "Maven" when prompted.
3. Reopen the project. (Close it and reopen)
4. Build p3 using IDEA's Maven Projects view; View -> Tool Windows -> Maven Projects
5. Open p3, then Lifestyle
6. Double click install.
7. A .jar file will be produced in /target called `p3 or p3-3-shaded.jar`
8. Place this .jar file in your plugins directory on your server.
9. Kill yourself for using IntelliJ like a brainlet

### Testing (No IDE)
1. Open a command prompt in protocol3
2. Start the command `mvnw.cmd package` (or `./mvnw package` on linux)
3. A .jar file will be produced in /target called `p3-3-shaded.jar`
4. Place this .jar in your plugins directory on your server.


### Contributing
Please comment any lines that may be unclear to someone who is less experienced with programming, and follow standard Java convention. If you are on Eclipse, please DISABLE auto-formatting on save. It is disabled by default; if you manually enabled it, disable it.

### Credits
The following people significantly contributed to cleaning protocol3 before release.  
<img src="https://avatars.githubusercontent.com/u/65378620?s=460&u=d16de1dd3e6ad7b79cca0dcc1fe46d5033f40e17&v=4" width=12></img>[d2k11](https://github.com/gcurtiss)  
<img src="https://avatars.githubusercontent.com/u/80420528?s=460&v=4" width=12></img>[ultradutch](https://github.com/ultra64cmy)  
<img src="https://avatars.githubusercontent.com/u/29944907?s=460&v=4" width=12></img>[timoreo](https://github.com/timoreo22)  
<img src="https://avatars.githubusercontent.com/u/46350196?s=460&u=447f50183eda50b12287813b8eb9dda596cc041f&v=4" width=12></img>[inferno4you](https://github.com/Infer4Y)  
<img src="https://avatars.githubusercontent.com/u/80420156?s=460&u=ceadf2cc69812f77b92b3b2566cdf397f44e9c7b&v=4" width=12></img>[RyzenRoll](https://github.com/RyzenRoll)  

### License
This software is licensed under [GNU AGPL v3](https://www.gnu.org/licenses/agpl-3.0.txt).
