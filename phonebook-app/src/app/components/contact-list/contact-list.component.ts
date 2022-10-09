import { Component, OnInit } from '@angular/core';
import { Contact } from 'src/app/model/contact';
import { PhonebookService } from 'src/app/service/phonebook.service';

@Component({
  selector: 'pb-contact-list',
  templateUrl: './contact-list.component.html',
  styleUrls: ['./contact-list.component.css']
})
export class ContactListComponent implements OnInit {

  contacts : Contact[];
  pageNum: number = 1;
  constructor(private service : PhonebookService) {}

  ngOnInit(): void {
    this.service.getAllContacts().subscribe(data => this.contacts = data);
  }

  loadMore() {
    this.pageNum++;
    this.service.getAllContacts(this.pageNum).subscribe(data => this.contacts = [...this.contacts, ...data]);
  }

}
