import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngforof-demo',
  templateUrl: './ngforof-demo.component.html',
  styleUrls: ['./ngforof-demo.component.css']
})
export class NgforofDemoComponent implements OnInit {

  imgStyles = {
    'height.px' : 50,
    'border-radius.px' : 5,
    'margin.px' : 5
  };

  people : Array<any>;

  constructor() { }

  ngOnInit(): void {
    this.people = [
      {name: 'Jacek', age: 20, city: 'Berlin', picture: '/assets/images/myPicture1.jpg'},
      {name: 'Marianna', age: 30, city: 'Hanover', picture: '/assets/images/myPicture2.jpg'},
      {name: 'Anna', age: 40, city: 'Paris', picture: '/assets/images/myPicture3.jpg'},
      {name: 'Wacek', age: 50, city: 'Lublin', picture: '/assets/images/myPicture4.jpg'}
    ]
  }

  getCssClass(age) {
    if(age<30){
      return 'text-danger';
    } else {
      return 'text-success';
    }

  }

  deletePerson(index){
    this.people.splice(index, 1);
  }

}
