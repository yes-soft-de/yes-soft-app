class ProjectEntity {
    /**
     * @param id ID
     * @param title string
     * @param link string
     * @param start_date string
     * @param end_date string
     * @param employee_id string
     */

    constructor(id, title, link, start_date, end_date, employee_id) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.start_date = start_date;
        this.end_date = end_date;
        this.employee_id = employee_id;
    }
}

export default ProjectEntity;
