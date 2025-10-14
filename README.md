## 🌿 Easeon - TrampleGuard
**Minecraft:** `1.21.10`  
**Loader:** `Fabric`  
**Side:** `Server-Side`, `Singleplayer`


## Overview
TrampleGuard is a server-side Fabric mod that prevents farmland from being trampled by any entity in your Minecraft world. Perfect for players who want to protect their crops from accidental destruction while farming or building around their fields.


## Commands
All commands require OP level 2 permission.

**View Current Status:**
```
/easeon trampleguard
```
**Enable Farmland Protection:**
```
/easeon trampleguard on
```
**Disable Farmland Protection:**
```
/easeon trampleguard off
```


## Configuration
```json
{
  "enabled": true,
  "requiredOpLevel": 2 // Requires a server restart to take effect.
}
```
`config/easeon/easeon.ss.trampleguard.json`
