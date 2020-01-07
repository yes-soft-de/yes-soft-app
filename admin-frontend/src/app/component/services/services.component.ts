import {Component, OnInit} from '@angular/core';
import {ServiceModel} from '../../model/service-model';
import {FlatTreeControl} from '@angular/cdk/tree';
import {ServiceFlatNode} from '../../control/service-flat-node';
import {MatTreeFlatDataSource, MatTreeFlattener} from '@angular/material';

@Component({
  selector: 'app-services',
  templateUrl: './services.component.html',
  styleUrls: ['./services.component.scss']
})

export class ServicesComponent implements OnInit {

  servicesList: ServiceModel[] = [
    {
      text: 'E-commerce Services',
      link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576445477/7111-basket-shopping-card-ecommerce-plus.json',
      bg: '#7B1FA2',
      text_color: '#FFFFFF',
      body: [
        {
          text: 'You Have An Idea',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576436397/2566-thinking-lamp.json',
          bg: '#FFFFFF',
          text_color: '#FFFFFF'
        },
        {
          text: 'We Have Technologies',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576445691/8633-web-development.json',
          bg: '#FFFFFF',
          text_color: '#FFFFFF'
        },
        {
          text: 'Together for More!!',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576445828/4028-coins-grow.json',
          bg: '#FFFFFF',
          text_color: '#FFFFFF'
        }
      ]
    },
    {
      text: 'Marketting Services',
      link: 'https://assets2.lottiefiles.com/packages/lf20_f7SKUU.json',
      bg: '#ffffff',
      text_color: '#000000',
      body: [
        {
          text: 'Too Many Platforms?',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576446106/11526-social-media.json',
          bg: '#FFFFFF',
          text_color: '#000000'
        },
        {
          text: 'Don\'t Have the Time?',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576446209/256-timer-3-second-loop.json',
          bg: '#FFFFFF',
          text_color: '#000000'
        },
        {
          text: 'We Can Help',
          link: 'https://assets6.lottiefiles.com/packages/lf20_VZWGZs.json',
          bg: '#FFFFFF',
          text_color: '#FFFFFF'
        }
      ]
    },
    {
      text: 'Android Development',
      link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576446341/1013-android.json',
      bg: '#AFB42B',
      text_color: '#000000',
      body: [
        {
          text: 'Need an App For Your API',
          link: 'https://assets1.lottiefiles.com/packages/lf20_GiGb4O.json',
          bg: '#FFFFFF',
          text_color: '#000000'
        },
        {
          text: 'We Can Help!!',
          link: 'https://assets6.lottiefiles.com/packages/lf20_VZWGZs.json',
          bg: '#FFFFFF',
          text_color: '#000000'
        }
      ]
    },
    {
      text: 'Remote Maintenance',
      link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576436397/2566-thinking-lamp.json',
      bg: '#ffffff',
      text_color: '#000000',
      body: [
        {
          text: 'Need a New Feature?',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576447173/6006-qr-code-scan.json',
          bg: '#FFFFFF',
          text_color: '#000000'
        },
        {
          text: 'Maybe Fixing a Problem in a Website?',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576447256/8750-alert.json',
          bg: '#FFFFFF',
          text_color: '#000000'
        },
        {
          text: 'We Can Help!!',
          link: 'https://res.cloudinary.com/micksawy3r/raw/upload/v1576446859/6209-social-media-service-bps.json',
          bg: '#FFFFFF',
          text_color: '#000000'
        }
      ]
    }
  ];

  constructor() {
  }

  ngOnInit() {
  }
}


