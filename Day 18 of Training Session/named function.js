//Program to demonstrate the named function in javascript
display=function displayname(ename)
{
  if(ename)
  {
    console.log(`Welcome ${ename}`)
  }
  else{
    console.log(`Welcome New user`)
  }
}
display()
d=display('Harika')
setTimeout(d,2000)
let displaydetails=function(obj)
{
  if(obj)
  {
    for(let [key,value] of Object.entries(obj))
    {
        console.log(key,'-',value)
    }
  }
  else
  {
    console.log("Nothing here to display")
  }
}
let dis=displaydetails
setTimeout(dis,30000)
dis({Name:'Sumukh',rollno:'IS073',dept:'ISE',year:'4th Year'})