package quang.cao.cvmanager.consts;

public interface ApiPath {
    String API = "/api/v1";

    //ping
    String PING = API + "/ping";

    // CV
    String CV_CREATE = API + "/cv/create";
    String CV_UPDATE_BY_NAME = API + "/cv/update-by-name";
    String CV_FIND_BY_NAME = API + "/cv/find-by-name";
    String CV_GET_ALL = API + "/cv/get-all";
    String CV_DELETE_BY_NAME = API + "/cv/delete-by-name";

    //Education
    String EDUCATION_CREATE = API + "/education/create";
    String EDUCATION_GET_ALL = API + "/education/get-all";
    String EDUCATION_GET_BY_ID = API + "/education/find-by-id";
    String EDUCATION_UPDATE_BY_ID = API + "/education/update-by-id";
    String EDUCATION_DELETE_BY_ID = API + "/education/delete-by-id";

    // Experience
    String EXPERIENCE_CREATE = API + "/experience/create";
    String EXPERIENCE_GET_ALL = API + "/experience/get-all";
    String EXPERIENCE_GET_BY_ID = API + "/experience/find-by-id";
    String EXPERIENCE_UPDATE_BY_ID = API + "/experience/update-by-id";
    String EXPERIENCE_DELETE_BY_ID = API + "/experience/delete-by-id";

    //JobApplication
    String JOB_APPLICATION_CREATE = API + "/job-application/create";
    String JOB_APPLICATION_GET_ALL = API + "/job-application/get-all";
    String JOB_APPLICATION_GET_BY_ID = API + "/job-application/find-by-id";
    String JOB_APPLICATION_UPDATE_BY_ID = API + "/job-application/update-by-id";
    String JOB_APPLICATION_DELETE_BY_ID = API + "/job-application/delete-by-id";

    //Skill
    String SKILL_CREATE = API + "/skill/create";
    String SKILL_GET_ALL = API + "/skill/get-all";
    String SKILL_GET_BY_ID = API + "/skill/find-by-id";
    String SKILL_UPDATE_BY_ID = API + "/skill/update-by-id";
    String SKILL_DELETE_BY_ID = API + "/skill/delete-by-id";
}
