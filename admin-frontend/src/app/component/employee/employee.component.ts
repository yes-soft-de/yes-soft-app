import {Component, OnInit} from '@angular/core';
import {faFacebook} from '@fortawesome/free-brands-svg-icons/faFacebook';
import {faGithub, faLinkedinIn, faTwitter} from '@fortawesome/free-brands-svg-icons';
import {EmployeeModel} from '../../model/employee-model';
import {MatDialog} from '@angular/material';
import {EditEmployeeComponent} from '../edit-employee/edit-employee/edit-employee.component';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.scss']
})
export class EmployeeComponent implements OnInit {

  employees: EmployeeModel[] = [];

  faFacebook = faFacebook;
  faTwitter = faTwitter;
  faLinkedIn = faLinkedinIn;
  faGitHub = faGithub;

  constructor(public dialog: MatDialog) {
    this.employees.push({
        id: 1,
        name: 'Mahmoud Aldiek',
        age: '30',
        quote: 'If you want to be special, you have to be ambitious first.',
        position: 'Emarketer & Content Creator',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944673/Mahmoud_Aldiek.jpg',
        linkedin: 'https://www.linkedin.com/in/mahmoud-aldiek-74a919196/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-16T21:01:44.710Z',
        updatedAt: '2019-12-21T16:20:53.478Z'
      },
      {
        id: 2,
        name: 'Mahmoud Al Kalaleeb',
        age: '24',
        quote: 'Success is a lifestyle',
        position: 'Full Stack Web Developer',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944681/Mohammad_Alkalaleeb.png',
        linkedin: 'https://www.linkedin.com/in/mohammad-al-kalaleeb/',
        facebook: null,
        twitter: null,
        github: 'https://github.com/MickSawy3r/',
        email: 'mailto:mohammad.al.kalaleeb@gmail.com',
        createdAt: '2019-12-21T16:30:57.035Z',
        updatedAt: '2019-12-21T16:30:57.035Z'
      },
      {
        id: 3,
        name: 'Nisreen Abu Zidan ',
        age: '24',
        quote: 'Nothing is true and everything is permissible',
        position: 'Business Development Manager',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944669/Nisreen_Abu_Zidan.jpg',
        linkedin: 'https://www.linkedin.com/in/nisreenabuzidan/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:35:38.894Z',
        updatedAt: '2019-12-21T16:35:38.894Z'
      },
      {
        id: 4,
        name: 'Mujeeba Haj Najeeb',
        age: '24',
        quote: 'Dream big & work hard',
        position: 'Scrum Master',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944667/Mujeeba_Haj_Najeeb.jpg',
        linkedin: 'https://www.linkedin.com/in/mujeeba-haj-najeeb-327228161/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:38:27.654Z',
        updatedAt: '2019-12-21T16:38:27.654Z'
      });
    this.employees.push({
        id: 1,
        name: 'Mahmoud Aldiek',
        age: '30',
        quote: 'If you want to be special, you have to be ambitious first.',
        position: 'Emarketer & Content Creator',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944673/Mahmoud_Aldiek.jpg',
        linkedin: 'https://www.linkedin.com/in/mahmoud-aldiek-74a919196/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-16T21:01:44.710Z',
        updatedAt: '2019-12-21T16:20:53.478Z'
      },
      {
        id: 2,
        name: 'Mahmoud Al Kalaleeb',
        age: '24',
        quote: 'Success is a lifestyle',
        position: 'Full Stack Web Developer',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944681/Mohammad_Alkalaleeb.png',
        linkedin: 'https://www.linkedin.com/in/mohammad-al-kalaleeb/',
        facebook: null,
        twitter: null,
        github: 'https://github.com/MickSawy3r/',
        email: 'mailto:mohammad.al.kalaleeb@gmail.com',
        createdAt: '2019-12-21T16:30:57.035Z',
        updatedAt: '2019-12-21T16:30:57.035Z'
      },
      {
        id: 3,
        name: 'Nisreen Abu Zidan ',
        age: '24',
        quote: 'Nothing is true and everything is permissible',
        position: 'Business Development Manager',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944669/Nisreen_Abu_Zidan.jpg',
        linkedin: 'https://www.linkedin.com/in/nisreenabuzidan/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:35:38.894Z',
        updatedAt: '2019-12-21T16:35:38.894Z'
      },
      {
        id: 4,
        name: 'Mujeeba Haj Najeeb',
        age: '24',
        quote: 'Dream big & work hard',
        position: 'Scrum Master',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944667/Mujeeba_Haj_Najeeb.jpg',
        linkedin: 'https://www.linkedin.com/in/mujeeba-haj-najeeb-327228161/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:38:27.654Z',
        updatedAt: '2019-12-21T16:38:27.654Z'
      });
    this.employees.push({
        id: 1,
        name: 'Mahmoud Aldiek',
        age: '30',
        quote: 'If you want to be special, you have to be ambitious first.',
        position: 'Emarketer & Content Creator',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944673/Mahmoud_Aldiek.jpg',
        linkedin: 'https://www.linkedin.com/in/mahmoud-aldiek-74a919196/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-16T21:01:44.710Z',
        updatedAt: '2019-12-21T16:20:53.478Z'
      },
      {
        id: 2,
        name: 'Mahmoud Al Kalaleeb',
        age: '24',
        quote: 'Success is a lifestyle',
        position: 'Full Stack Web Developer',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944681/Mohammad_Alkalaleeb.png',
        linkedin: 'https://www.linkedin.com/in/mohammad-al-kalaleeb/',
        facebook: null,
        twitter: null,
        github: 'https://github.com/MickSawy3r/',
        email: 'mailto:mohammad.al.kalaleeb@gmail.com',
        createdAt: '2019-12-21T16:30:57.035Z',
        updatedAt: '2019-12-21T16:30:57.035Z'
      },
      {
        id: 3,
        name: 'Nisreen Abu Zidan ',
        age: '24',
        quote: 'Nothing is true and everything is permissible',
        position: 'Business Development Manager',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944669/Nisreen_Abu_Zidan.jpg',
        linkedin: 'https://www.linkedin.com/in/nisreenabuzidan/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:35:38.894Z',
        updatedAt: '2019-12-21T16:35:38.894Z'
      },
      {
        id: 4,
        name: 'Mujeeba Haj Najeeb',
        age: '24',
        quote: 'Dream big & work hard',
        position: 'Scrum Master',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944667/Mujeeba_Haj_Najeeb.jpg',
        linkedin: 'https://www.linkedin.com/in/mujeeba-haj-najeeb-327228161/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:38:27.654Z',
        updatedAt: '2019-12-21T16:38:27.654Z'
      });
    this.employees.push({
        id: 1,
        name: 'Mahmoud Aldiek',
        age: '30',
        quote: 'If you want to be special, you have to be ambitious first.',
        position: 'Emarketer & Content Creator',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944673/Mahmoud_Aldiek.jpg',
        linkedin: 'https://www.linkedin.com/in/mahmoud-aldiek-74a919196/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-16T21:01:44.710Z',
        updatedAt: '2019-12-21T16:20:53.478Z'
      },
      {
        id: 2,
        name: 'Mahmoud Al Kalaleeb',
        age: '24',
        quote: 'Success is a lifestyle',
        position: 'Full Stack Web Developer',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944681/Mohammad_Alkalaleeb.png',
        linkedin: 'https://www.linkedin.com/in/mohammad-al-kalaleeb/',
        facebook: null,
        twitter: null,
        github: 'https://github.com/MickSawy3r/',
        email: 'mailto:mohammad.al.kalaleeb@gmail.com',
        createdAt: '2019-12-21T16:30:57.035Z',
        updatedAt: '2019-12-21T16:30:57.035Z'
      },
      {
        id: 3,
        name: 'Nisreen Abu Zidan ',
        age: '24',
        quote: 'Nothing is true and everything is permissible',
        position: 'Business Development Manager',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944669/Nisreen_Abu_Zidan.jpg',
        linkedin: 'https://www.linkedin.com/in/nisreenabuzidan/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:35:38.894Z',
        updatedAt: '2019-12-21T16:35:38.894Z'
      },
      {
        id: 4,
        name: 'Mujeeba Haj Najeeb',
        age: '24',
        quote: 'Dream big & work hard',
        position: 'Scrum Master',
        image: 'https://res.cloudinary.com/micksawy3r/image/upload/v1576944667/Mujeeba_Haj_Najeeb.jpg',
        linkedin: 'https://www.linkedin.com/in/mujeeba-haj-najeeb-327228161/',
        facebook: null,
        twitter: null,
        github: null,
        email: null,
        createdAt: '2019-12-21T16:38:27.654Z',
        updatedAt: '2019-12-21T16:38:27.654Z'
      });
  }

  ngOnInit() {
  }

  editEmployee(id: number) {
    const dialogRef = this.dialog.open(EditEmployeeComponent, {
      width: '100vw',
      height: '75vh'
    });
    dialogRef.afterClosed().subscribe(
      () => {
        console.log('Should Refresh the List');
      }
    );
  }
}
