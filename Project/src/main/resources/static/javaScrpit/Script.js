/**
 * 
 */
function clearErrors() {//it is used for clear the previous error
    const errors = document.getElementsByClassName('formerror');
    for (let item of errors) {
        item.innerHTML = "";
    }
}

function setError(id, error) {
    const element = document.getElementById(id);//set error to the id of that input fiels
    element.nextElementSibling.innerHTML = error; // Display error next to input
}

function validateForm() {
    let returnval = true;
    clearErrors();

    const name = document.forms['myForm']["fname"].value;
	const namePattern =  /^[A-Za-z]+( [A-Za-z]+){0,2}$/; 
    if(name.length==0)
		{
			setError("name", "*Enter the name");
			returnval = false;
		}
		else if (!namePattern.test(name)) {
			setError("name", "*Name should only contain alphabetic characters");
			returnval = false;
		}
	else if (name.length < 5) {
        setError("name", "*Length of name is too short");
        returnval = false;
    }
	

     
	


    const email = document.forms['myForm']["femail"].value.trim();
	const emailPattern = /^[^\d\s][A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
	 if (email.length == 0) {
        setError("email", "*Enter Email");
        returnval = false;
    }
    else if(email.length >30) {
        setError("email", "*Length of Email is too long");
        returnval = false;
    }
	else if (!emailPattern.test(email)) { 
		setError("email", "*Invalid email format");
		returnval = false;
	}




    const phone = document.forms['myForm']["fphone"].value.trim();
	if (phone.length == 0) {
        setError("phone", "*Enter Phone NUmber");
        returnval = false;
    }
     else if (phone.length !== 10) {
        setError("phone", "*Phone number should be 10 digits");
        returnval = false;
    }




    const password = document.forms['myForm']["fpass"].value.trim();
	if (password.length==0) {
        setError("pass", "*Enter Password");
        returnval = false;
    }
	
    else if (password.length < 6) {
        setError("pass", "*Password should be at least 6 characters");
        returnval = false;
    }




    const cpassword = document.forms['myForm']["fcpass"].value.trim();
	if(cpassword.length==0)
		{
			setError("cpass", "*Enter Confirm Password");
			returnval = false;
	
		}
   else if (cpassword !== password) {
        setError("cpass", "*Passwords do not match");
        returnval = false;
    }


 const Date = document.forms['myForm']["date"].value;
 if (Date==0) {
	setError("date", "*Enter the date");
	returnval = false;
}

	const education = document.forms['myForm']["education"].value;
    if (education==0) {
        setError("educat", "*Select the education");
        returnval = false;
    }
	const Country = document.forms['myForm']["country"].value;
    if (Country==0) {
        setError("count", "*Select the Country");
        returnval = false;
    }


	const State = document.forms['myForm']["state"].value;
    if (State==0) {
        setError("state", "*Select the State");
        returnval = false;
    }
	const City = document.forms['myForm']["city"].value;
    if (City==0) {
        setError("city", "*Select the city");
        returnval = false;
    }

    return returnval;
}
