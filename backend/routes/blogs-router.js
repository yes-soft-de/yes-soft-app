import BlogsController from '../controllers/BlogsController';
import express from "express";

const router = express.Router();
const blogsController = new BlogsController();


router.get('/', (req, res) => {
    blogsController.findBlogAll(res);
});

router.get('/:id', (req, res) => {
    blogsController.findBlogAll(req, res);
});

router.get('employee/:id', (req, res) => {
    blogsController.findBlogByEmployeeId(req, res);
});

router.post('/', (req, res) => {
    blogsController.createBlog(req, res);
});


router.delete('/:id', (req, res) => {
    blogsController.deleteBlog(req, res);
});

export default router;
