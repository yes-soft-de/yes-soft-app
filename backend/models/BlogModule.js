import Model from './Module';
import BlogEntity from '../entity/BlogEntity';

class BlogModule {

    constructor() {
        this.model = new Model();
    }

    findAll() {
        const sql = `SELECT * FROM blogs`;

        return this.model.findAll(sql)
            .then((resultList) => {
                const blogList = [];

                for (const result of resultList) {
                    blogList.push(new BlogEntity(result.id, result.title, result.start_date, result.link));
                }

                return blogList;
            });
    }

    findBlogById(id) {
        const sql = `SELECT * FROM blogs WHERE id = $id`;
        const params = {
            $id: id
        };

        return this.model.findOne(sql, params)
            .then((result) => {
                return new BlogEntity(result.id, result.name, result.age, result.position, result.quote, result.link);
            });
    }

    findBlogByEmployeeId(id) {
        const sql = `SELECT * FROM blogs WHERE employee_id = $id`;
        const params = {
            $id: id
        };

        return this.model.findOne(sql, params)
            .then((resultList) => {
                const blogList = [];

                for (const result of resultList) {
                    blogList.push(new BlogEntity(result.id, result.title, result.start_date, result.link));
                }

                return blogList;
            });
    }

    createInfo(blog) {
        const sql = `INSERT INTO blogs (employee_id, title, link, start_date) 
            VALUES (${blog.employee_id}, "${blog.title}", "${blog.link}", "${emplyee.start_date}");`;
        const params = {
            $e_id: blog.employee_id,
            $title: blog.title,
            $link: blog.link,
            $date: blog.date
        };

        return this.model.run(sql, params)
            .then((id) => {
                return this.model.findOne(id);
            });
    }

    delete(id) {
        const sql = `DELETE FROM blogs WHERE id = $id`;

        const params = {
            $id: id
        };

        return this.model.run(sql, params);
    }
}

export default BlogModule;
