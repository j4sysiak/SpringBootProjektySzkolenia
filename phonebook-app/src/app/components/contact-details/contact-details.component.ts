import { Component, OnInit } from '@angular/core';
import { Contact } from '../../model/contact';
import { PhonebookService } from 'src/app/service/phonebook.service';

@Component({
  selector: 'pb-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit {

  contact: Contact = new Contact();

  constructor(private service : PhonebookService) { }

  ngOnInit() {
    this.service.getContactDetails(1).subscribe(data => this.contact = data);
  }

}


































