# F2P Star Assist

A plugin for crowdsourcing shooting stars in F2P.

## Features

- Sidebar panel with list of known stars.
    - Double-click a star entry to hop to the world of a star.
    - Right-click to remove entries.
- Analyzes chat messages for star calls.
- Arrow hint for a star found in your world.
- Optional: Communication with a webserver to share your stars with others.

### Group communication settings

#### Configuring groups

To configure your groups, use the "groups" field in the config.
The text in this field must be formatted as a [JSON Object](https://www.json.org/json-en.html).
The key of each property would be the name of the group, and the value would be your group's secret authentication code.

For example, if you hunt stars just with one group (e.g. your clan), then this would look as follows:
```json
{
  "AwesomeClan" : "a_very_secret_unguessable_string_of_random_characters"
}
```

If you are in two hunting groups (e.g. your clan and a star hunting friendschat), your json object would look as follows:

```json
{
  "BestClanOSRS" : "SomeVerySecretUnguessableCodeGoesHere",
  "A Friend's chat": "ADifferentSecretGroupCodeGoesHere"
}
```

You can add more groups by adding more json properties.

#### Webserver settings

To enable communication with a central server for sharing stars, tick the 'Enable webserver communication' checkbox
in the 'Webserver Settings' configuration section.

The URL should be provided to you by one of your group leaders. For example:
```https://some.domain.net```.

#### Keeping found stars separated between groups

Say you are in two star hunting groups A and B, and you don't want stars called by group A being shared to group B.
You can then in the 'Sharing Settings' section select which calls gets shared to which groups.

To configure the groups that get informed when you encounter a star in the world edit the value of the 'Share stars I find with groups:' box:

```BestClanOSRS;A Friend's chat```.

You can share to multiple groups by separating them using a semicolon.

When a player is the first player to send star info to the webserver the groups of that player will be treated as the 'owner' of that star,
and when a player from another group finds it and shares it to the webserver, then the server will ignore it. \
When a player requests the list of known stars, the web server will respond with ONLY those stars
that are 'owned' by the groups the player is in. \
To see all the tested scenario's please refer to the [StarDatabaseScenarioTest](https://github.com/Jannyboy11/F2P-Star-Assist/blob/master/Web-Server/src/test/java/com/janboerman/f2pstarassist/web/StarDatabaseScenarioTest.java).
Even if you can't read Java code this is a useful resource because the comments explain what's going on.

#### Chat analysis

For 4 different chat message types you can configure to which groups they are shared. These types are
* Private chat
* Clan chat
* Friends chat
* Public chat

E.g. continuing the example of star hunting with two separated groups (cc and fc) use the following configuration:

At `Share friends chat calls with group:` configure it as `A Friend's chat`. \
At `Share clan chat calls with group:` configure it as `BestClanOSRS`.

To share calls with multiple groups, you can put multiple group names in the same text box, separated by a semicolon.

## Compiling

Prerequisites:
- A JDK, version [17](https://jdk.java.net/17/) or higher
- [Apache Maven](https://maven.apache.org/)

Then run `mvn clean package` to generate the jar files.

## PluginHub-compatible repo
Is located [here](https://github.com/Jannyboy11/F2P-Star-Assist-PluginHub).
