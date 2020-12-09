package com.example.favorite;

public class Pojo {

	private int id;
	private String Job_Id;
	private String Job_Catid;
	private String Job_Image;
	private String Job_Name;
	private String Job_Desc;
	private String Job_Salary;
	private String Job_Vacancy;
	private String Job_Designation;
	private String Job_Skill;
	private String Job_Mail;
	private String Job_Phoneno;
	private String Job_Site;
	private String Job_Comname;
	private String Job_Address;
	private String Job_Country;
	private String Job_Maplati;
	private String Job_Maplongi;

	public Pojo()
	{

	}

	public Pojo(String Job_Id)
	{
		this.Job_Id=Job_Id;
	}

	public Pojo(String jid,String jcid,String jimage,String jname,String jdesc,String jsalary,String jvacancy,String jdesign,String jskill,String jmail,String jphoneno,String jsite,String jcomname,String jaddress,String jcountry,String jmaplati,String jmaplongi)
	{
		this.Job_Id=jid;
		this.Job_Catid=jcid;
		this.Job_Image=jimage;
		this.Job_Name=jname;
		this.Job_Desc=jdesc;
		this.Job_Salary=jsalary;
		this.Job_Vacancy=jvacancy;
		this.Job_Designation=jdesign;
		this.Job_Skill=jskill;
		this.Job_Mail=jmail;
		this.Job_Phoneno=jphoneno;
		this.Job_Site=jsite;
		this.Job_Comname=jcomname;
		this.Job_Address=jaddress;
		this.Job_Country=jcountry;
		this.Job_Maplati=jmaplati;
		this.Job_Maplongi=jmaplongi;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getJob_Id(){
		return Job_Id;
	}
	public void setJob_Id(String job_id){
		this.Job_Id=job_id;
	}
	public String getJob_Catid() {
		return Job_Catid;
	}

	public void setJob_Catid(String job_catid) {
		this.Job_Catid = job_catid;
	}
	public String getJob_Image() {
		return Job_Image;
	}

	public void setJob_Image(String job_image) {
		this.Job_Image = job_image;
	}
	public String getJob_Name() {
		return Job_Name;
	}

	public void setJob_Name(String job_name) {
		this.Job_Name = job_name;
	}
	public String getJob_Desc() {
		return Job_Desc;
	}

	public void setJob_Desc(String job_desc) {
		this.Job_Desc = job_desc;
	}
	public String getJob_Salary() {
		return Job_Salary;
	}

	public void setJob_Salary(String job_salary) {
		this.Job_Salary = job_salary;
	}
	public String getJob_Vacancy() {
		return Job_Vacancy;
	}

	public void setJob_Vacancy(String job_vacancy) {
		this.Job_Vacancy = job_vacancy;
	}
	public String getJob_Designation() {
		return Job_Designation;
	}

	public void setJob_Designation(String job_designation) {
		this.Job_Designation = job_designation;
	}
	public String getJob_Skill() {
		return Job_Skill;
	}

	public void setJob_Skill(String job_skill) {
		this.Job_Skill = job_skill;
	}
	public String getJob_Mail() {
		return Job_Mail;
	}

	public void setJob_Mail(String job_mail) {
		this.Job_Mail = job_mail;
	}
	public String getJob_Phoneno() {
		return Job_Phoneno;
	}

	public void setJob_Phoneno(String job_phoneno) {
		this.Job_Phoneno = job_phoneno;
	}
	public String getJob_Site() {
		return Job_Site;
	}

	public void setJob_Site(String job_site) {
		this.Job_Site = job_site;
	}
	public String getJob_Comname() {
		return Job_Comname;
	}

	public void setJob_Comname(String job_comname) {
		this.Job_Comname = job_comname;
	}
	public String getJob_Address() {
		return Job_Address;
	}

	public void setJob_Address(String job_address) {
		this.Job_Address = job_address;
	}
	public String getJob_Country() {
		return Job_Country;
	}

	public void setJob_Country(String job_country) {
		this.Job_Country = job_country;
	}
	public String getJob_Maplati() {
		return Job_Maplati;
	}

	public void setJob_Maplati(String job_maplati) {
		this.Job_Maplati = job_maplati;
	}
	public String getJob_Maplongi() {
		return Job_Maplongi;
	}

	public void setJob_Maplongi(String job_maplongi) {
		this.Job_Maplongi = job_maplongi;
	}
}
