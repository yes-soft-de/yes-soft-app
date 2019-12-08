package de.yessoft.android.mapper.EmployeeDetailsMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.entity.Blog;
import de.yessoft.android.entity.EmployeeDetails;
import de.yessoft.android.entity.EmployeeInfo;
import de.yessoft.android.entity.Project;
import de.yessoft.android.entity.Skill;

public class EmployeeDetailsMapper implements IEmployeeMapper{

    private static final String KEY_INFO = "info";
    private static final String KEY_SKILLS = "skills";
    private static final String KEY_PROJECTS = "projects";
    private static final String KEY_BLOGS = "blogs";

    private static final String KEY_INFO_NAME = "name";
    private static final String KEY_INFO_AGE = "age";
    private static final String KEY_INFO_IMAGE_LINK = "link";
    private static final String KEY_INFO_POSITION = "position";

    private static final String KEY_BLOG_TITLE = "title";
    private static final String KEY_BLOG_PUBLISH_DATE = "date";
    private static final String KEY_BLOG_LINK = "link";

    private static final String KEY_PROJECT_TITLE = "title";
    private static final String KEY_PROJECT_LINK = "link";
    private static final String KEY_PROJECT_START_DATE = "start_date";
    private static final String KEY_PROJECT_END_DATE = "end_date";

    public EmployeeDetails toEmployeeDetails(JSONObject object) throws JSONException {
        if (object == null) {
            return null;
        }

        JSONObject infoJson = object.getJSONObject(KEY_INFO);
        EmployeeInfo info = getEmployeeInfo(infoJson);

        JSONArray skillsJson = object.getJSONArray(KEY_SKILLS);
        List<Skill> skills = getSkillsList(skillsJson);

        JSONArray blogsJson = object.getJSONArray(KEY_BLOGS);
        List<Blog> blogsList = getBlogList(blogsJson);

        JSONArray projectsJson = object.getJSONArray(KEY_PROJECTS);
        List<Project> projectList = getProjectList(projectsJson);

        return new EmployeeDetails(info, skills, blogsList, projectList);
    }

    private List<Project> getProjectList(JSONArray projectJson) throws JSONException {
        List<Project> projectList = new ArrayList<>();
        for (int i = 0; i < projectJson.length(); i++) {
            projectList.add(toProject(projectJson.getJSONObject(i)));
        }
        return projectList;
    }

    private Project toProject(JSONObject projectJson) throws JSONException {
        return new Project(
                projectJson.getString(KEY_PROJECT_TITLE),
                projectJson.getString(KEY_PROJECT_LINK),
                projectJson.getString(KEY_PROJECT_START_DATE),
                projectJson.getString(KEY_PROJECT_END_DATE)
        );
    }

    private List<Blog> getBlogList(JSONArray blogs) throws JSONException {
        List<Blog> blogList = new ArrayList<>();
        for (int i = 0; i < blogs.length(); ++i) {
            blogList.add(toBlog(blogs.getJSONObject(i)));
        }

        return blogList;
    }

    private Blog toBlog(JSONObject blogObject) throws JSONException {
        return new Blog(
                blogObject.getString(KEY_BLOG_TITLE),
                blogObject.getString(KEY_BLOG_LINK),
                blogObject.getString(KEY_BLOG_PUBLISH_DATE)
        );
    }

    private List<Skill> getSkillsList(JSONArray skillsJson) throws JSONException {
        List<Skill> skills = new ArrayList<>();
        if (skillsJson.length() > 0) {
            for (int i = 0; i < skillsJson.length(); ++i) {
                skills.add(new Skill(skillsJson.getString(i)));
            }
        }
        return skills;
    }

    private EmployeeInfo getEmployeeInfo(JSONObject infoJson) throws JSONException {
        EmployeeInfo info = new EmployeeInfo();
        info.setName(infoJson.getString(KEY_INFO_NAME));
        info.setAge(infoJson.getString(KEY_INFO_AGE));
        info.setImageLinks(infoJson.getString(KEY_INFO_IMAGE_LINK));
        info.setPosition(infoJson.getString(KEY_INFO_POSITION));
        return info;
    }
}
