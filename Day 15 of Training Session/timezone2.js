//Program to demonstrate the list of available timezones in javascript
// Get all available IANA time zones
const timeZones = Intl.supportedValuesOf("timeZone");
 
// Get the current time in each zone
timeZones.forEach(zone => {
  let time = new Intl.DateTimeFormat("en-US", 
    {
    timeZone: zone,
    timeStyle: "medium",
    dateStyle: "short"
  }).format(new Date());
 
  console.log(zone, "→", time);
});
 