export enum vehicleType{
    BUS,
    VAN,
    CAR,
    TRUCK
}
// function checkAccess1(type:vehicleType):string{
//     switch(type){
//         case vehicleType.BUS:
//             return "Full access granted";
//         case vehicleType.VAN:
//             return "Guest access only";
//         case vehicleType.CAR:
//             return "Limited access";
//         case vehicleType.TRUCK:
//             return "Acess granted"
//         default:
//             return "No access";
//     }
// }

// console.log(checkAccess1(vehicleType.CAR));
// console.log(checkAccess1(vehicleType.VAN));


export enum vehicleStatus{
    AVAILABLE,
    ON_TRIP,
    MAINTENANCE
}
// function checkAccess2(status:vehicleStatus):string{
//     switch(status){
//         case vehicleStatus.ON_TRIP:
//             return "Full access granted";
//         case vehicleStatus.MAINTENANCE:
//             return "Guest access only";
//         case vehicleStatus.AVAILABLE:
//             return "Limited access";
//         default:
//             return "No access";
//     }
// }

// console.log(checkAccess2(vehicleStatus.ON_TRIP));
// console.log(checkAccess2(vehicleStatus.MAINTENANCE));


export enum availabilityStatus{
    AVAILABLE,
    ON_TRIP,
    OFF_DUTY
}

export enum bookingStatus{
    PENDING,
    CONFIRMED,
    COMPLETED,
    CANCELLED
}