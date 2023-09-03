import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
selector: 'app-logs',
templateUrl: './logs.component.html',
styleUrls: ['./logs.component.css']
})
export class LogsComponent implements OnInit {
logs: Object= {};

constructor(private http: HttpClient) {} // end constructor

ngOnInit() {
this.getLogs();
} // end method ngOnInit

getLogs() {
this.http.get('http://localhost:8080/logs').subscribe(logs => {
this.logs = logs;
});
} // end method
} // end class
