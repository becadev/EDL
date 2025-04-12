import random

# Gerar 10 números aleatórios
random_numbers = [random.randint(1, 200) for _ in range(1000000)]

# Salvar os números em um arquivo .txt
with open("t6.txt", "w") as file:
    for number in random_numbers:
        file.write(str(number) + "\n")