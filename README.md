# RandomLight
### RandomLight - A Minecraft plugin enabling terrain lighting within a selected range

## Why RandomLight?
RandomLight is a plugin that works on all versions where the light block is available, additionally, it is fully configurable.

## Support
To get support, join our [Discord](https://discord.gg/7jqMGp535d).

## Compatibility
Our plugin is available for all Minecraft versions that support the light block (1.17-1.20.4).

## Configuration

```yaml
# RlLight plugin by gasnic
# Support: https://discord.gg/JJayWyCzBV
# Versions: 1.8-1.20
# support by Olomowo Studio (2024)

messages:
  playeronly: "this command cannot be used as console."
  nopermission: "you do not have permission to use this command."
  maxradius: "You must change the radius in config!"
  reload: "reloaded config."
  usage: "To use /rlight, you must provide an argument (int)."
# here you can set your own message names
permissions:
  start: "rlight.start"
  reload: "rlight.reload"

# here you can set your own permission names
maxRadius: 100
# maxRadius is the maximum range at which the plugin will place light blocks
```
