import express from 'express';
import ProjectController from '../controllers/ProjectController';

const router = express.Router();
const projectController = new ProjectController();


router.get('/', (req, res) => {
    projectController.findProjectAll(res);
});

router.get('/:id', (req, res) => {
    projectController.findProjecById(req, res);
});

router.get('employee/:id', (req, res) => {
    projectController.findProjectByEmployeeId(req, res);
});

router.post('/', (req, res) => {
    projectController.createProject(req, res);
});


router.delete('/:id', (req, res) => {
    projectController.deleteProject(req, res);
});

export default router;
