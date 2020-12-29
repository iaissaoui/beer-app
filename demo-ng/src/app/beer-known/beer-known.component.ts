import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-beer-known',
  templateUrl: './beer-known.component.html',
  styleUrls: ['./beer-known.component.scss']
})
export class BeerKnownComponent implements OnInit {

  private _id!: number;


  constructor(
    private router:Router,
    private route: ActivatedRoute) {

     }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];
  }

  public get id(): number {
    return this._id;
  }
  public set id(value: number) {
    this._id = value;
  }

}
