function makePayment() {

    const paymentMethod = document.querySelector('input[name="payment"]:checked').value;

    // Cash on Delivery
    if (paymentMethod === "Cash on Delivery") {

        document.getElementById("checkoutForm").submit();
        return;
    }

    let totalText = document.querySelector(".bill-total span:last-child").innerText;

    totalText = totalText.replace("₹","").trim();

    let amount = Math.round(parseFloat(totalText) * 100);

    // Call CreateOrderServlet

    fetch("createOrder",{

        method:"POST",

        headers:{
            "Content-Type":"application/x-www-form-urlencoded"
        },

        body:"amount="+amount

    })

    .then(response=>response.json())

    .then(order=>{

        var options={

            key:"rzp_test_TEGSzLIlJklQwS",

            amount:order.amount,

            currency:"INR",

            name:"Flavora",

            description:"Food Delivery Payment",

            image:"images/logo.png",

            order_id:order.id,

            handler:function(response){

                let form=document.getElementById("checkoutForm");

                let paymentId=document.createElement("input");

                paymentId.type="hidden";

                paymentId.name="razorpay_payment_id";

                paymentId.value=response.razorpay_payment_id;

                form.appendChild(paymentId);

                let orderId=document.createElement("input");

                orderId.type="hidden";

                orderId.name="razorpay_order_id";

                orderId.value=response.razorpay_order_id;

                form.appendChild(orderId);

                let signature=document.createElement("input");

                signature.type="hidden";

                signature.name="razorpay_signature";

                signature.value=response.razorpay_signature;

                form.appendChild(signature);

                form.submit();

            },

            theme:{
                color:"#FC8019"
            }

        };

        var rzp=new Razorpay(options);

        rzp.open();

    })

    .catch(error=>{

        alert("Unable to start payment!");

        console.log(error);

    });

}