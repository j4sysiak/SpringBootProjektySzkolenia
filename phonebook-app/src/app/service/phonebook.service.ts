import { Injectable } from '@angular/core';
import { Contact } from '../model/contact';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import 'rxjs/add/operator/map'; 
import { map } from 'rxjs/operators';
import { identifierModuleUrl } from '@angular/compiler';

//npm install rxjs-compat

const baseUrl = 'http://localhost:4300/contacts/';

@Injectable({
  providedIn: 'root'
})
export class PhonebookService {

  constructor(private http: HttpClient) { }
 
  getContactDetails(id: number) : Observable<Contact> {

    return this.http.get(baseUrl + id).pipe(map(data => data as Contact));    
  }

  addNewContact(contact: Contact) : Observable<Contact> {
    
    return this.http.post(baseUrl, contact).pipe(map(data => data as Contact));
  }

  updateContact(contact: Contact) : Observable<Contact> {

    return this.http.put(baseUrl + contact.id, contact).pipe(map(data => data as Contact));
  }

  deleteContact(id: number) : Observable<any> {

    return this.http.delete(baseUrl + id);    
  }

  getAllContacts(pageNumber: number = 1): Observable<Contact[]> {

    let params = {
      '_page': '' + pageNumber
    }
    return this.http.get(baseUrl, {params}).pipe(map(resp => resp as Contact[]));
  }

}






































