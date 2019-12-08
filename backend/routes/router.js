import express from 'express';
import projectRouter from './projects-router';
import employeeRouter from './employee-router';
import blogsRouter from './blogs-router';
import skillsRouter from './skill-router';

const router = express.Router();

router.use((req, res, next) => {
    console.log(`${req.url} [${req.method}] : ${JSON.stringify(req.body)}`);

    next();
});

router.use('/project', projectRouter);
router.use('/employee', employeeRouter);
router.use('/blog', blogsRouter);
router.use('/skill', skillsRouter);

export default router;
