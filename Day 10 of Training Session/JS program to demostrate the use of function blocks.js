//Program to demonstrate the use of let variables and var variables in the function block
function fun()
{
    v3=73.21;
    console.log("The value of v1 before assigning the value is ",v1);
    var v1=23;
    console.log("The value of v1 after assigning the value is ",v1);
    display();
    function display()
    {
        console.log("The value of v2 before assigning the value is ",v2);
        var v2="Supercalifragilisticexpialidocious";
        v1="Maximus Decimus Meridius";
        console.log("The value of v2 after assigning the value is ",v2);
        console.log("The value of v1 after modification is- ",v1); //We can use the v1 variable inside the function of its defined function
    }
    console.log(v1);
     console.log(v2)    //We can not use the v2 variable outside its defined function
}
fun();
