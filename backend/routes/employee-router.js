import express from 'express';
import EmployeeController from '../controllers/EmployeeControler';

const router = express.Router();
const employeeController = new EmployeeController();


router.get('/', (req, res) => {
    employeeController.findEmployeeAll(res);
});

router.get('/:id', (req, res) => {
    employeeController.findEmployeeById(req, res);
});


router.post('/', (req, res) => {
    employeeController.createEmployee(req, res);
});


router.delete('/:id', (req, res) => {
    employeeController.deleteEmployee(req, res);
});

export default router;
