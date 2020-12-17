export class Beer {

    

    private _id!: number;
    private _name!: string;
    private _tagline!: string;
    private _first_brewed!: Date;
    private _description!: string;
    private _image_url!: string;
    private _abv!: number;

	constructor() {
	}

    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get tagline(): string {
        return this._tagline;
    }
    public set tagline(value: string) {
        this._tagline = value;
    }
    public get first_brewed(): Date {
        return this._first_brewed;
    }
    public set first_brewed(value: Date) {
        this._first_brewed = value;
    }
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }
    public get image_url(): string {
        return this._image_url;
    }
    public set image_url(value: string) {
        this._image_url = value;
    }
    public get abv(): number {
        return this._abv;
    }
    public set abv(value: number) {
        this._abv = value;
    }





    
}
