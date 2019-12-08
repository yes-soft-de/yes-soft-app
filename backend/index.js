import express from 'express';
import bodyParser from 'body-parser';
import db from './db/db';
import router from './routes/router';

const app = express();

db.init();

app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
    res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
    next();
});

const port = process.env.PORT || 3000;
app.listen(port, () => {
    console.log(`Hello From ${port}`);
});

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

const restApiRoot = '/api';
app.use(restApiRoot, router);
