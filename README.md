# RandomLight
### RandomLight - Plugin do minecraft umożliwiający oświetlenie terenu w wybranym zasięgu

## Dlaczego Randomlight?
RandomLight to plugin, który działa na wszystkich wersjach, na których dostępny jest blok światła, dodatkowo jest on w pełni konfigurowalny

## Wsparcie
Aby uzyskać wsparcie, dołącz na naszego [Discorda](https://discord.gg/7jqMGp535d)

## Kompatybilność
Nasz plugin dostępny jest na wszystkie wersje Minecraft obsługujące blok światła (1.17-1.20.4)

## Konfiguracja

```yaml
# RlLight plugin by gasnic
# Support: https://dc.mythicalshop.pl
# Versions: 1.8-1.20

messages:
  playeronly: "this command cannot be used as console."
  nopermission: "you do not have permission to use this command."
  maxradius: "You must change the radius in config!"
  reload: "reloaded config."

# here you can set your own message names
permissions:
  start: "rlight.start"
  reload: "rlight.reload"

# here you can set your own permission names
maxRadius: 100
# maxRadius is the maximum range at which the plugin will place light blocks

#Permissions: (You can change that)
# rlight.start
# rlight.reload
```
