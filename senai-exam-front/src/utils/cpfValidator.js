const cpfValidator = (cpf) => {
    let sum;
    let remain;
    sum = 0;
    if (cpf === "00000000000") {
        return false
    }

    for (let i=1; i<=9; i++) {
        sum = sum + parseInt(cpf.substring(i-1, i)) * (11 - i);
    }
    remain = (sum * 10) % 11;

    if ((remain === 10) || (remain === 11)){
        remain = 0;
    }
    if (remain !== parseInt(cpf.substring(9, 10)) ) {
        return false;
    }

    sum = 0;
    for (let i = 1; i <= 10; i++) {
        sum = sum + parseInt(cpf.substring(i-1, i)) * (12 - i);
    }
    remain = (sum * 10) % 11;

    if ((remain === 10) || (remain === 11)){
        remain = 0;
    }
    return remain === parseInt(cpf.substring(10, 11));

}
export default cpfValidator