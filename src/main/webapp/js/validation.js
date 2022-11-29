function validate(frm){
	
	
	//document.getElementById("demo");

	const enameErr=document.getElementById("enameErr");
	
	const jobErr=document.getElementById("jobErr");

	const salErr=document.getElementById("salErr");
	
	
	
	//Cleaning all the errors
	enameErr.innerHTML="";
	jobErr.innerHTML="";
	salErr.innerHTML="";
	
	
	let flag=true;
	
	let ename=frm.ename.value;
	let job=frm.job.value
	let sal=frm.sal.value
	
	if(ename==""){
		enameErr.innerHTML="Employee name is Required---";
		flag =false;
	}else if(ename.length>10){
		enameErr.innerHTML="Eployee name should not be more than 10 characters---";
		flag=false;
	}else{
		if(job==""){
			jobErr.innerHTML="Job is Required---";
			flag=false;
		}else if(job.length>=10){
			jobErr.innerHTML="Job should be less than 10 characters ---";
			flag=false;
		}else{
			if(sal==""){
				salErr.innerHTML="Salary is required---";
				flag=false;
			}else if(isNaN(sal)){
				salErr.innerHTML="salary must be numeric value---";
				flag=false;
			}else if(sal<1000||sal>90000){
				salErr.innerHTML="salary must between the 1000 to 90000---";
			}
		}
	}
	
	frm.vflag.value="yes";
	
	return flag;
}