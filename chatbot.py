print("Customer Chatbot Started!")
print("Type exit to stop")

while True:

    msg = input("You: ").lower()

    if msg == "exit":
        print("Bot: Bye! Have a nice day!")
        break

    elif "hello" in msg or "hi" in msg:
        print("Bot: Hello! How can I help you?")

    elif "order" in msg:
        print("Bot: Track orders in My Orders section.")

    elif "refund" in msg:
        print("Bot: Refund takes 5-7 working days.")

    elif "delivery" in msg:
        print("Bot: Delivery takes 3-5 days.")

    elif "payment" in msg:
        print("Bot: We accept UPI, Card, and Net Banking.")

    else:
        print("Bot: Sorry, I didn't understand.")