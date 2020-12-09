package com.example.util;

import java.io.Serializable;

public class Constant implements Serializable{

	/**
	 * 
	 */		private static final long serialVersionUID = 1L;

	 //this is the path of uploaded image of server where image store
	 public static final String SERVER_IMAGE_UPFOLDER="http://viaviweb.in/Apps/job_apps/images/";
	 
	 //this is the path of thumb images
	 public static final String SERVER_IMAGE_THUMB="http://viaviweb.in/Apps/job_apps/images/thumb/";

	 //this url gives list of category 
	 public static final String CATEGORY_URL = "http://viaviweb.in/Apps/job_apps/api.php?";

	 //this url gives category list
	 public static final String CATEGORYLIST_URL="http://viaviweb.in/Apps/job_apps/api.php?category_id=";



	 public static final String CATEGORY_ARRAY_NAME="JobApps";
	 public static final String CATEGORY_CID="cid";
	 public static final String CATEGORY_NAME="category_name";
	 public static final String CATEGORY_IMAGE="category_image";

	 public static final String JOB_ID="id";
	 public static final String JOB_CAT_ID="category_id";
	 public static final String JOB_NAME="job_name";
	 public static final String JOB_DESIGN="job_designation";
	 public static final String JOB_DESC="job_desc";
	 public static final String JOB_SALARY="job_salary";
	 public static final String JOB_COMNAME="job_company_name";
	 public static final String JOB_SITE="job_company_website";
	 public static final String JOB_PHNENO="phone_number";
	 public static final String JOB_MAIL="job_mail";
	 public static final String JOB_VACANCY="job_vacancy";
	 public static final String JOB_ADDRESS="job_address";
	 public static final String JOB_QUALI="job_qualification";
	 public static final String JOB_SKILL="job_skill";
	 public static final String JOB_IMAGE="job_image";
	 public static final String JOB_MAPLATI="job_map_latitude";
	 public static final String JOB_MAPLONGI="job_map_longitude";
	 public static final String JOB_STATUS="job_status";
	 

	 public static int CATEGORYID;
	 public static String CATEGORYNAME;
	 public static String CATEGORYLIST_PRO_PIDD;

}
