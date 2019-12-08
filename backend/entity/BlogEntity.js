class BlogEntity {
    /**
     * @param id ID
     * @param title string
     * @param date string
     * @param link string
     */

    constructor(id, title, date, link, employee_id) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.link = link;
        this.employee_id = employee_id;
    }
}

export default BlogEntity;