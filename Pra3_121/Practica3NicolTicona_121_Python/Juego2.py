# Nicol Yanina Ticona Aduviri
# R.U; 1855987
import random

class Juego:
    def __init__(self, numeroDeVidas):
        self.numeroDeVidas = numeroDeVidas
        self.record = 0

    def reiniciaPartida(self):
        self.numeroDeVidas = self.numeroDeVidas 

    def actualizaRecord(self):
        if self.numeroDeVidas > self.record:
            self.record = self.numeroDeVidas
            print(f"¡Tu puntaje actual es: {self.record}!")
    
    def quitaVida(self):
        self.numeroDeVidas = self.numeroDeVidas - 1
        print(f"Vidas restantes: {self.numeroDeVidas}")
        return self.numeroDeVidas > 0


class JuegoAdivinaNumero(Juego):
    def __init__(self, numeroDeVidas):
        super().__init__(numeroDeVidas)
        self.numeroAAdivinar = 0

    def validaNumero(self, numero):
        """Acepta int o str y valida rango 0-10"""
        if isinstance(numero, str):
            if not numero.isdigit():
                return False
            numero = int(numero)
        return 0 <= numero <= 10
    
    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.randint(0, 10)
        print("************* Adivina un numero entre 0 y 10 *************")        
        while True:
            entrada = input("Ingresa un número: ")
            
            if not self.validaNumero(entrada):
                print("Error: Debe ser un número entre 0 y 10")
                continue
                
            numero = int(entrada)
            
            if numero == self.numeroAAdivinar:
                print("¡Acertaste!")
                self.actualizaRecord()
                break
            else:
                if not self.quitaVida():
                    print("Te has quedado sin vidas. El número era:", self.numeroAAdivinar)
                    break
                elif numero < self.numeroAAdivinar:
                    print("El número a adivinar es mayor")
                else:
                    print("El número a adivinar es menor")


class JuegoAdivinaPar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        """Valida que sea número par entre 0 y 10"""
        if isinstance(numero, str):
            if not numero.isdigit():
                return False
            numero = int(numero)

        if not (0 <= numero <= 10):
            return False
        if numero % 2 == 0:
            return True
        else:
            print("Error: El número debe ser par")
            return False

    def juega(self): 
        self.reiniciaPartida()
        self.numeroAAdivinar = random.choice([0, 2, 4, 6, 8, 10])
        print("************* Adivina un numero par entre 0 y 10 *************")
        
        while True:
            entrada = input("Ingresa un número PAR: ")
            
            if not self.validaNumero(entrada):
                print("Error: Debe ser un número PAR entre 0 y 10")
                continue
                
            numero = int(entrada)
            
            if numero == self.numeroAAdivinar:
                print("¡Acertaste!")
                self.actualizaRecord()
                break
            else:
                if not self.quitaVida():
                    print("Te has quedado sin vidas. El número era:", self.numeroAAdivinar)
                    break
                elif numero < self.numeroAAdivinar:
                    print("El número a adivinar es mayor")
                else:
                    print("El número a adivinar es menor")


class JuegoAdivinaImpar(JuegoAdivinaNumero):
    def validaNumero(self, numero):
        """Valida que sea número impar entre 0 y 10"""
        if isinstance(numero, str):
            if not numero.isdigit():
                return False
            numero = int(numero)

        if not (0 <= numero <= 10):
            return False
        if numero % 2 != 0:
            return True
        else:
            print("Error: El número debe ser impar")
            return False

    def juega(self):
        self.reiniciaPartida()
        self.numeroAAdivinar = random.choice([1, 3, 5, 7, 9])
        print("************* Adivina un numero impar entre 0 y 10 *************")
        
        while True:
            entrada = input("Ingresa un número IMPAR: ")
            
            if not self.validaNumero(entrada):
                print("Error: Debe ser un número IMPAR entre 0 y 10")
                continue
            numero = int(entrada)
            
            if numero == self.numeroAAdivinar:
                print("¡Acertaste!")
                self.actualizaRecord()
                break
            else:
                if not self.quitaVida():
                    print("Te has quedado sin vidas. El número era:", self.numeroAAdivinar)
                    break
                elif numero < self.numeroAAdivinar:
                    print("El número a adivinar es mayor")
                else:
                    print("El número a adivinar es menor")


class Aplicacion:
    def main(self):
        print("")
        print("-------------------- Juego de las adivinanzas --------------------")
        print("--------------------------- par e impar ---------------------------")
        print("BIENVENIDO A LOS JUEGOS DE ADIVINANZA")
        
        juegos = [
            JuegoAdivinaPar(2),
            JuegoAdivinaImpar(3)
        ]
        
        tipos_juego = ["Par", "Impar"]
        
        for i, juego in enumerate(juegos):
            print(f"\n============ Juego Adivina Número {tipos_juego[i]} ============")
            juego.juega()
            print()


if __name__ == "__main__":
    app = Aplicacion()
    app.main()
