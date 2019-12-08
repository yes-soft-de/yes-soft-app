import BlogModel from '../models/BlogModule';
import BlogEntity from '../entity/BlogEntity';
import Controller from './controller';

class BlogsController {

    constructor() {
        this.controller = new Controller();
        this.blogModel = new BlogModel();
    }

    findBlogAll(res) {
        this.blogModel.findAll()
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    findBlogById(req, res) {
        const id = req.params.id;

        this.blogModel.findBlogById(id)
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    findBlogByEmployeeId(req, res) {
        const id = req.params.employee_id;

        this.blogModel.findBlogByEmployeeId(id)
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    createBlog(req, res) {
        const blog = new BlogEntity();
        blog.employee_id = req.body.employee_id;
        blog.title = req.body.title;
        blog.start_date = req.body.start_date;
        blog.link = req.body.link;

        this.blogModel.createBlog(employee)
            .then(this.controller.createSuccess(res))
            .catch(this.controller.editError(res));
    }

    deleteBlog(req, res) {
        const id = req.params.id;

        this.blogModel.deleteBlog(id)
            .then(this.controller.editSuccess(res))
            .catch((error) => {
                if (error.errorCode === 21) {
                    return this.controller.deleteError(res)();
                }
                else {
                    return this.controller.editError(res)();
                }
            });
    }
}

export default BlogsController;
