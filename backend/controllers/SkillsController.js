import Controller from './controller';
import SkillModule from '../models/SkillModule';
import SkillsEntity from '../entity/SkillsEntity';

class SkillsController {

    constructor() {
        this.controller = new Controller();
        this.skillModel = new SkillModule();
    }

    findSkillAll(res) {
        this.skillModel.findAll()
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    findSkillById(req, res) {
        const id = req.params.id;

        this.skillModel.findSkillByEmployeeId(id)
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    findSkillByEmployeeId(req, res) {
        const id = req.params.id;

        this.skillModel.findSkillByEmployeeId(id)
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    createSkill(req, res) {
        const skill = new SkillsEntity();
        skill.skill = req.body.skill;
        skill.employee_id = req.body.employee_id;

        this.skillModel.createSkill(skill)
            .then(this.controller.createSuccess(res))
            .catch(this.controller.editError(res));
    }

    deleteSkill(req, res) {
        const id = req.params.id;

        this.blogModel.delete(id)
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

export default SkillsController;
