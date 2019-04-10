let noUser=true;
let user=false;
let admin=false;

function showLogin(){
    document.getElementById('login').innerHTML='Log In';
}

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



if(noUser){showLogin();
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



