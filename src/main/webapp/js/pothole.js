let noUser=true;
let user=false;
let admin=false;

function showLogin(){
    document.getElementById('login').innerHTML='Log In';
    document.getElementById('login').addEventListener("click", function (showHideLoginForm){
        {
            let form=document.createElement("form");
            form.setAttribute('method',"post");
            form.setAttribute('action',"submit");
            form.setAttribute('autocomplete',"off");
            let username=document.createElement("input");
            username.setAttribute('type',"text");
            username.setAttribute('name',"username");
            username.setAttribute('placeholder',"Username")
            let password=document.createElement("input");
            password.setAttribute('type',"text");
            password.setAttribute('name',"password");
            password.setAttribute('placeholder',"Password")
            let submit=document.createElement("input");
            submit.setAttribute('type',"submit");
            submit.setAttribute('value',"submit");
            form.appendChild(username);
            form.appendChild(password);
            form.appendChild(submit);
            document.getElementById('main-navbar').appendChild(form);
        };
})};

function showSignUp(){
    document.getElementById('signup').innerHTML='Sign Up';
}

function showReportPothole(){
    document.getElementById('report-pothole').innerHTML='Report a Pothole';
}

function showUpdatePothole(){
    document.getElementById('update-pothole').innerHTML='Update a Pothole';
}

function showScheduleMaintenance(){
    document.getElementById('schedule-maintenance').innerHTML='Schedule Pothole Maintenance';
}

function showLogout(){
    document.getElementById('logout').innerHTML='Log Out';
}

if(noUser){
    showLogin();
    showSignUp();
}

if(user){
    showReportPothole();
    showLogout();
}

if(admin){
    showReportPothole();
    showUpdatePothole();
    showScheduleMaintenance();
    showLogout();
}



