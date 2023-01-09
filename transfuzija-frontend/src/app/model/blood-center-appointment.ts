import { BloodCenterAdministrator } from "./blood-center-administrator";
import { BloodTransfusionCenter } from "./blood-transfusion-center";
import { RegisteredClient } from "./registered-client";

export class BloodCenterAppointment {
    id!: number;
    appointmentStart!: Date;
    duration!: number;
    center!: BloodTransfusionCenter;
    client!: RegisteredClient;
    stuff!: BloodCenterAdministrator;
}