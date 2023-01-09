export class RegisteredClient {
    id!: number;
	email!: string;
	name!: string;
	surname!: string;
	address!: string;
	city!: string;
	country!: string;
	phoneNumber!: string;
	jmbg!: string;
	gender!: string;
	occupation!: string;
	jobInformation!: string;
	blocked = false;
	penalties = 0;

}