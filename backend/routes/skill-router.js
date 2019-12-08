import express from 'express';
import SkillsController from '../controllers/SkillsController';

const router = express.Router();
const skillsController = new SkillsController();


router.get('/', (req, res) => {
    skillsController.findSkillAll(res);
});

router.get('/:id', (req, res) => {
    skillsController.findSkillById(req, res);
});

router.get('employee/:id', (req, res) => {
    skillsController.findSkillByEmployeeId(req, res);
});

router.post('/', (req, res) => {
    skillsController.createSkill(req, res);
});


router.delete('/:id', (req, res) => {
    skillsController.deleteSkill(req, res);
});

export default router;
